regex_curp = /[A-Z][AEIOU][A-Z]{2}[0-9]{2}(0[1-9]|1[0-2])(0[0-9]|[1-2][0-9]|3[0-1])[MH][A-Z]{2}[B-DF-HJ-NP-TV-Z]{3}[0-9A-Z][0-9]/
m1 = regex_curp.match "MEGA990203HGRNNL05"
puts m1
puts m1.class
m2 = "MEGA980203HGRNNL05" =~ regex_curp
puts m2

=begin
m3 = regex_curp.match "RIGA050131MGRSNHR4"
puts m3
puts m3.class
m4 = "RIGA050131MGRSNHR4" =~regex_curp
puts m4
=end