(format T "¿Cual es tu nombre? ")

(defvar *nombre* (read-line))

(defun saludar (*nombre*)
    (format t "Hola ~A! ~%")
)

(setq *print-case* :capitalize)
(saludar *nombre*)