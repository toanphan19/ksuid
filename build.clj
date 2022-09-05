(ns build
  (:require [clojure.tools.build.api :as b]
            [org.corfield.build :as bb]))

(def lib 'com.github.toanphan19/ksuid)
;; (def version (format "0.2.%s" (b/git-count-revs nil)))
(def version "0.2.0")

(def class-dir "target/classes")
(def basis (b/create-basis {:project "deps.edn"}))
(def jar-file (format "target/%s-%s.jar" (name lib) version))

(defn jar [_]
  (println "Version:" version)
  (bb/clean nil)
  (println "Building jar...")
  (b/write-pom {:class-dir class-dir
                :lib lib
                :version version
                :basis basis
                :src-dirs ["src"]})
  (b/copy-dir {:src-dirs ["src" "resources"]
               :target-dir class-dir})
  (b/jar {:class-dir class-dir
          :jar-file jar-file}))

(defn deploy "Deploy to Clojars." [opts]
  (-> opts
      (assoc :lib lib :version version)
      (bb/deploy)))
