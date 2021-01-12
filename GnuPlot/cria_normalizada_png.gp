set term png
set output "Gnuplot/normalizada_tmp.png"

set title "Modelo"
set xlabel "Geracao"
set ylabel "Numero Femeas"

stats 'Output\\normalizada.txt' nooutput
stats 'Output\\normalizada.txt' skip 1
max_col = STATS_columns

set border 3
set tics nomirror
set grid
set ytics 25
set key autotitle columnhead 


plot for [i=1:max_col] "Output\\normalizada.txt" u 0:i w l  

pause mouse any "Any key or button will terminate"