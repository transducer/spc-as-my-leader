(ns build)

(defn foo
  {:shadow.build/stage :flush}
  [build-state]
  (println "foo")
  build-state)
