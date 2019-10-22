(ns build)

(defn foo
  {:shadow.build/stage :flush}
  [build-state]
  (println "foo")
  build-state)

(defn fibo-iter
  ([n] (fibo-iter 0 1 n)
   ([curr nxt n]
    (cond
      (zero? n) curr
      :else (recur nxt (+ curr nxt) (dec n))))))
