(defproject numbers2words "0.1.0-SNAPSHOT"
  :description "numbers2words Clojure lib [WeFarm:GG]"
  :url "https://clojars.org/repo"
  :license {:name "GG Public License"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]]
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}
             :dev {:plugins [[quickie "0.4.2"]]
                   :repl-options {:server "localhost"
                                  :port 4555}}})
