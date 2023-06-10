package com.example;

public class Tuple {
    private int N, P1, P2;
    Tuple(int p1, int p2, int n){
        N = n;
        P1 = p1;
        P2 = p2;
    }
    Integer getN(){return N;}
    Integer getP1(){return P1;}
    Integer getP2(){return P2;}
    void print(){
        System.out.println(N);
        System.out.println(P1);
        System.out.println(P2);
    }
}
