package com.blas;

import java.util.Arrays;

import com.github.fommil.netlib.BLAS;

/**
 * Created  on 2017/11/24.
 * Description:
 *  java.lang.String transa, java.lang.String transb, int m, int n, int k,
 *  double alpha, double[] a, int _a_offset, int lda, double[] b,
 *  int _b_offset, int ldb, double beta, double[] c, int _c_offset, int Ldc
 * @author : wangyi
 */
public class BalsRunnable implements Runnable {


    private String transa;
    private String transb;
    private int m;
    private int n;
    private int k;
    private double alpha;
    private double[] a;
    private int _a_offset;
    private int lda;
    private double[] b;
    private int _b_offset;
    private int ldb;
    private double beta;
    private double[] c;
    private int _c_offset;
    private int ldc;


    public BalsRunnable(String transa, String transb, int m,
            int n, int k,
            double alpha, double[] a, int _a_offset, int lda, double[] b,
            int _b_offset, int ldb, double beta, double[] c,
            int _c_offset, int ldc) {
        this.transa = transa;
        this.transb = transb;
        this.m = m;
        this.n = n;
        this.k = k;
        this.alpha = alpha;
        this.a = a;
        this._a_offset = _a_offset;
        this.lda = lda;
        this.b = b;
        this._b_offset = _b_offset;
        this.ldb = ldb;
        this.beta = beta;
        this.c = c;
        this._c_offset = _c_offset;
        this.ldc = ldc;
    }

    @Override
    public void run() {

        try {

            BLAS  blas =  BLAS.getInstance();
            blas.dgemm(transa, transb, m, n, k,
                    alpha, a, _a_offset, lda, b, _b_offset, ldb,
                    beta, c, _c_offset, ldc);

            System.out.println("c.rows:"+ m + "   c.cols:"+n
                    + "   c.data:"+ Arrays.toString(c)
                    + "   c._c_offset:"+_c_offset
                    + "   c.ldc:"+ldc);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
