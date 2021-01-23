set term png
set output "Gnuplot/variacao_tmp.png"


set title "Modelo de Leslie"
set xlabel "Geração"
set ylabel "variacao"

set border 3
set tics nomirror
set grid


set style line 1 \
    linecolor rgb '#000000' \
    linetype 1 linewidth 2 \
    pointtype 7 pointsize 1

plot "Output\\variacao.txt" title "Variacao" with linespoints linestyle 1

