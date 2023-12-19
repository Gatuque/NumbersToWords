(ns numbers2words.core-test
  (:require [clojure.test :refer :all]
            [numbers2words.core :refer :all]))

(deftest get-words-tests
  (testing "passing wrong inputs to get-words"
    ;(is (thrown? IllegalArgumentException (get-words -10)))
    ;(is (thrown? IllegalArgumentException (get-words  10.0)))
    ;(is (thrown? IllegalArgumentException (get-words "10")))
    ;(is (thrown? IllegalArgumentException (get-words 1056.87539)))
    ;(is (thrown? IllegalArgumentException (get-words 1000000000)))
    ;(is (thrown? IllegalArgumentException (get-words 1000000050)))
           )

  (testing "passing correct inputs"
    (are [number translation] (= number translation)
                              (get-words 0) "zero"
                              (get-words 1) "one"
                              (get-words 21) "twenty-one"
                              (get-words 105) "one hundred and five"
                              (get-words 123) "one hundred and twenty-three"
                              (get-words 1005) "one thousand and five"
                              (get-words 1042) "one thousand and forty-two"
                              (get-words 1105) "one thousand one hundred and five"
                              (get-words 56945781) "fifty-six million nine hundred and forty-five thousand seven hundred and eighty-one"
                              (get-words 999999999)  "nine hundred and ninety-nine million nine hundred and ninety-nine thousand nine hundred and ninety-nine")))

(deftest twenty-to-hundred-words-test
  (testing "Testing 0 to 99 number translation"
    (are [word number] (= word number)
                       "zero" (zero-to-100-words 0)
                       "nine" (zero-to-100-words 9)
                       "fifteen" (zero-to-100-words 15)
                       "fifty-six" (zero-to-100-words 56)
                       "ninety-nine" (zero-to-100-words 99)))
  (testing "Testing numbers > 99")
  (are [number translation] (not= number translation)
                            "one hundred" (zero-to-100-words 100)
                            "one hundred and ten" (zero-to-100-words 110))
  (is (thrown? IndexOutOfBoundsException (zero-to-100-words 900)))
  (is (thrown? IndexOutOfBoundsException (zero-to-100-words 750))))


