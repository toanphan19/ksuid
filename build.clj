(ns build
  (:require [clojure.tools.build.api :as b]
            [org.corfield.build :as bb]
            [clojure.java.shell :as sh]
            [clojure.string :as string]))

(def lib 'toanphan19/ksuid)
(def version (some-> (sh/sh "git" "describe" "--tags" "--abbrev=0")
                     :out
                     (string/trim-newline)))

(println "version " version)
