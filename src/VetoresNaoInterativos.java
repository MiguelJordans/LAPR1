import org.la4j.Matrix;
import org.la4j.decomposition.EigenDecompositor;
import org.la4j.matrix.dense.Basic2DMatrix;
import java.io.IOException;

/**
 * Classe respetiva ao cálculo do vetor próprio e valor próprio do modo não interativo
 */

public class VetoresNaoInterativos {


    /**
     * @param matriz matriz original
     * @param nomeficheiro ficheiro onde vão ser guardadas as informações respetivas ao vetor próprio e ao valor próprio
     * @throws IOException
     */

    public static void vetorproprio(double[][] matriz, String nomeficheiro) throws IOException {

        Matrix a = new Basic2DMatrix(matriz);

        EigenDecompositor eigenD = new EigenDecompositor(a);
        Matrix[] mattD = eigenD.decompose();

        double[][] matA = mattD[0].toDenseMatrix().toArray(); //matA - vetor proprio, cálculo do vetor próprio

        double[][] matB = mattD[1].toDenseMatrix().toArray(); //matB - valor proprio, cálculo do valor próprio

        double[] VetorColuna = Vectores.VetorProprio(matA); //obter o vetor próprio ( correto ), pois antes era apenas uma matriz com valores respetivos ao vetor próprio
        double[] VetorNormalizado = Vectores.NormalizarVetorProprio(VetorColuna); //normalização do vetor próprio

        double lambda = Vectores.maiorValorProprio(matB); //obter o maior valor próprio

        Grava.valorproprio(lambda,nomeficheiro); //Gravar no ficheiro o valor próprio
        Grava.vetorproprio(VetorNormalizado,nomeficheiro); //Gravar no ficheiro o vetor próprio

    }

}