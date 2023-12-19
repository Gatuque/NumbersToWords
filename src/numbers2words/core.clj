(ns numbers2words.core
  ^{:author "George Gatuma"
    :created  "20th February 2021"
    :title "Numbers To Words Translation Lib (WeFarm Interview"}
  (:require [clojure.string :as str]))

(def zero-2-19 ["zero" "one" "two" "three" "four" "five" "six" "seven" "eight" "nine" "ten"
                "eleven" "twelve" "thirteen" "fourteen" "fifteen" "sixteen" "seventeen" "eighteen" "nineteen"])

(def powers-of-ten ["twenty" "thirty" "forty" "fifty" "sixty" "seventy" "eighty" "ninety" "thousand" "million" "billion" "trillion"
                    "Quadrillion" "Quintillion" "Sextillion" "Septillion" "Octillion"])

(declare get-words)

(defn britishchQ
      [val]
      (let [[fval lval] (str/split (str val) #"\.")]
           (cond
             (zero? (clojure.edn/read-string fval))  (str (get-words (clojure.edn/read-string  lval)) " pence")
             lval (str (get-words (clojure.edn/read-string fval)) " pounds and "
                       (get-words (clojure.edn/read-string  lval)) " pence only")
             :else
             (str (get-words (clojure.edn/read-string fval)) " pounds")
             ))
      )


(def zero-to-100-words
  (fn [num]
    (let [[tens-pow remd] (if (< num 20) [(zero-2-19 num) 0] ;This is to cater for num values that are less than 20
                                         ;Deduct 2 to remove the 1st 2 indexes taken care by < 20 i.e 0s and 10s
                                         [(-> (quot num 10)  (- 2) powers-of-ten)
                                          (rem num 10)])]
      (if (zero? remd) tens-pow (str tens-pow "-" (zero-2-19 remd))))))

(defn greater-than-1000
      [numb]
      (loop [words []
             new_num numb
             indx 7]
            (if (zero? new_num)
              (str/join " " words)
              (let [[remd pow] [(rem new_num 1000) (quot new_num 1000)]
                    words (if (zero? remd) words
                                           (let [wds (get-words remd)] ;recur to get-words to process tail remainder value
                                                (cons
                                                  ;;since we know we have passed the 6th index of powers-of-ten we start from 7th index i.e thousand
                                                  (if (= indx 7)
                                                    (if (< remd 100) (str "and " wds) wds)
                                                    (str wds " " (powers-of-ten indx)))
                                                  words)))]
                   (recur words pow (inc indx))))))


(defn get-words
  [numb]
  ;(when (not (and (integer? numb) ))                        ;(<= 0 numb 999999999)
  ;  (throw (IllegalArgumentException. (str numb " is not a valid integer"))))
  (condp > numb
    100  (zero-to-100-words numb)
    1000 (let [[hund-pow remd] [(-> (quot numb 100) zero-2-19 (str " hundred"))
                                (rem numb 100)]]
           (if (zero? remd) hund-pow (str hund-pow " and " (zero-to-100-words remd))))
    (greater-than-1000 numb)))
