(ns peg-thing.core
  (require [clojure.set :as set])
  (:gen-class))

(declare successful-move prompt-move game-over query-row)
(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn positive-number
  ([] (positive-number 1))
  ([n] (lazy-seq (cons n (positive-number (inc n))))))

(defn fib
  ([] (fib 1 1 ))
  ([a b] (lazy-seq (cons a (fib b (+ a b))))))

(defn tri*
  "Generates lazy sequence of triangular numbers"
  ([] (tri* 0 1))
  ([sum n] (let [new-sum (+ sum n)]
             (cons new-sum (lazy-seq (tri* new-sum (inc n)))))))

(def tri (tri*))
(take 5 tri)

(defn triangular?
  [n]
  (= n (last (take-while #(>= n %) tri))))

(triangular? 5)
(triangular? 6)

(defn row-tri
  "The triangular number of the end of row n"
  [n]
  (last (take n tri)))

(defn row-num
  "Returns row number the position belongs to: pos 1 in row 1,
  position 2 and 3 in row etc"
  [pos]
  (inc (count (take-while #(> pos %) tri))))

(row-num 1)
(row-num 5)

(defn connect
  "Form a mutual connection between positions"
  [board max-pos pos neighbor destintion]
  )
