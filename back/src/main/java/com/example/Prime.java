package com.example;
import java.util.*;


public class Prime {
    List<Integer> prime_collection = new ArrayList<>();
    Integer Size;
    public Prime(int n) {
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);

        for (int p = 2; p * p <= n; p++) {
            if (primes[p]) {
                for (int i = p * p; i <= n; i += p) {
                    primes[i] = false;
                }
            }
        }

        
        for (int i = 2; i <= n; i++) {
            if (primes[i]) {
                prime_collection.add(i);
            }
        }
        Size = prime_collection.size();
    }
    
    public List<Tuple> get_all_tuples(){
        List<Tuple> result = new ArrayList<Tuple>();
        int n = prime_collection.size();
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                Tuple tupla = new Tuple(prime_collection.get(i), prime_collection.get(j), prime_collection.get(i) * prime_collection.get(j));
                result.add(tupla);
            }
        }
        return result;
    }
    public Integer get_size(){return Size;}
    
}
