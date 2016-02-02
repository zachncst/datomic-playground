(ns datomic-playground.core
  (:require [datomic.api :as d]))

(defn reset-db []
  (d/delete-database uri)
  (d/create-database uri))

(require '[datomic.api :as d])

(def uri "datomic:free://localhost:4334/nav-tactical")

(def conn (d/connect uri))

(def db (d/db conn))

(def startDate (.plus (java.time.LocalDate/now) -28 java.time.temporal.ChronoUnit/DAYS))

(def endDate (java.time.LocalDate/now))

(def input ["schooldude.com" startDate endDate])
