public class DiffieHellmanExchange {
    
    /*
        Problem:
        Alice and Bobs agree on p=11 and g=2  
        Alice secret key is 9 
        Bob secret key is 4 
        What is their shared secret key using Diffie Hellman? 
        
        calculation formula: https://en.wikipedia.org/wiki/Diffie%E2%80%93Hellman_key_exchange
    */

    static class Person{
        public int p;
        public int g;
        public int private_key;

        public int Key(){
            return (int) (Math.pow(g, private_key) % p);
        }

        public int sharedKey(int other_public_key){
            return (int) (Math.pow(other_public_key,private_key)%p);
        }
    }


    public static void main(String... args){
        Person Alice = new Person();
        Alice.p = 11;
        Alice.g = 2;
        Alice.private_key = 9;

        System.out.println("Alice Public Key: "+Alice.Key());

        Person Bob = new Person();
        Bob.p = 11;
        Bob.g = 2;
        Bob.private_key = 4;

        System.out.println("Bob Public Key: "+Bob.Key());

        System.out.println("Shared Key: "+Alice.sharedKey(Bob.Key()));
    }
}
