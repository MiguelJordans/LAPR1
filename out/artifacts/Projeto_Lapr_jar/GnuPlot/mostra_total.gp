set title "Modelo de Leslie"
set xlabel "Geração"
set ylabel "Número Femeas"

set border 3
set tics nomirror
set grid


set style line 1 \
    linecolor rgb "#000000" \
    linetype 1 linewidth 2 \
    pointtype 7 pointsize 1


plot "Output\\total.txt" title "Total da População" with linespoints linestyle 1

pause mouse any "Any key or button will terminate"