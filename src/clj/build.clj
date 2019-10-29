(ns build)

(defn map-2 [f coll]
  (when (seq coll)
    (cons (f (first coll))
          (map-2 f (rest coll)))))

(map-2 inc [1 2 3])






(defmacro unless [pred & body]
  (list 'if (list 'not pred) (cons 'do body)))

(unless (= 1 1) (println "Evaluated"))
