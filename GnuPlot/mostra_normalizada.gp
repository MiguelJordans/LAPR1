

set title "Modelo"
set xlabel "Geracao"
set ylabel "Numero Femeas"

stats 'Output\\normalizada.txt' nooutput
stats 'Output\\normalizada.txt' skip 1
max_col = STATS_columns

set border 3
set tics nomirror
set grid
set key autotitle columnhead


plot for [i=2:max_col] "Output\\normalizada.txt" u 0:i w l

pause mouse any "Any key or button will terminate"