(ns build)

(defn map* [f coll]
  (when (seq coll)
    (cons (f (first coll))
          (map* f (rest coll)))))

(map* inc [1 2])
