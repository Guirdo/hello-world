# https://ruby-doc.org/stdlib-2.5.1/libdoc/matrix/rdoc/Matrix.html

require 'matrix'

matriz = Matrix[[1,2,3],
                [1,2,3],
                [1,2,3]]

matriz.each(:diagonal) do |i|
    puts i
end