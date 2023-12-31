set terminal dumb
set output "Gnuplot/nao_normalizada_tmp.txt"

set title "Modelo de Leslie"
set xlabel "Geracao"
set ylabel "Numero Femeas"

stats 'Output\\nao_normalizada.txt' nooutput
stats 'Output\\nao_normalizada.txt' skip 1
max_col = STATS_columns

set border 3
set tics nomirror
set grid
set key autotitle columnhead
set logscale xy



plot for [i=2:max_col] "Output\\nao_normalizada.txt" u 0:i w l

pause mouse any "Any key or button will terminate"