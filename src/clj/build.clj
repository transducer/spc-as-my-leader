(ns build)

(defn map-2 [f coll]
  (when (seq coll)
    (cons (f (first coll))
          (map* f (rest coll)))))

(map-2 inc [1 2 3])






(defmacro unless [pred & clauses]
  `(if (not ~pred) ~@clauses))

(unless (= 2 1) (println "evaluated"))
