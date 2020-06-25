


#Principal
f = File.open("test.avp", "r")
f.each_line do |linea|
  puts linea
end
f.close