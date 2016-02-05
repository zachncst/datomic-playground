(defproject datomic-playground "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [com.datomic/datomic-pro "0.9.5327"]]
  :plugins [[lein-datomic "0.2.0"]]
  :main ^:skip-aot datomic-playground.core
  :target-path "target/%s"
  :profiles {:dev {:datomic {:config "resources/free-transactor-template.properties"
                             :db-uri "datomic:dev://localhost:4334/nav-tactical"}}
             :uberjar {:aot :all}})
