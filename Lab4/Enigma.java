import static java.lang.System.out;
public class Enigma {
    public Rotor inner;
    public Rotor middle;
    public Rotor outer;
    
    /**
     *Constructor
     */
    public Enigma(String first, String second, String third) {
        inner = new Rotor(first);
        middle = new Rotor(second);
        outer = new Rotor(third);
    }

    /**
     *Encrypts the provided string
     */
    public String encrypt(String encryptMe) {
        char current;
        int currentIndex;

        char[] arrayToEncrypt = encryptMe.toCharArray();
        for (int nn = 0; nn<arrayToEncrypt.length; nn++){
            current = arrayToEncrypt[nn];
            if (current != '#'){
                
                //find the index of the current character in the inner rotor
                currentIndex=inner.rotorString.indexOf(current);

                //find the character of the outer rotor alligned with that index
                current=outer.rotorString.charAt(currentIndex);

                //find the index that character in the middle rotor
                currentIndex=middle.rotorString.indexOf(current);

                //find the character of the outer rotor alligned with that index
                arrayToEncrypt[nn]=outer.rotorString.charAt(currentIndex);
            }
            
            rotateMachine();
        }
        String encrypted = new String(arrayToEncrypt);
        return encrypted;
    }

    /**
     *Decripts the provided string
     */
    public String decrypt(String decryptMe) {
        char current;
        int currentIndex;

        char[] arrayToDecrypt = decryptMe.toCharArray();
        for (int nn = 0; nn<arrayToDecrypt.length; nn++){
            current = arrayToDecrypt[nn];
            if (current != '#'){               
                //find the character of the outer rotor alligned with that index
                currentIndex =outer.rotorString.indexOf(current);
          
                current =middle.rotorString.charAt(currentIndex);
                
                //find the index that character in the middle rotor
                currentIndex =outer.rotorString.indexOf(current);

                arrayToDecrypt[nn]=inner.rotorString.charAt(currentIndex);
            }
            
            rotateMachine();
        }

        String decrypted = new String(arrayToDecrypt);
        return decrypted;
    }


    /**
     *Rotates the Enigma
     */
    public void rotateMachine() {
        char[] innerArray = inner.rotorString.toCharArray();
        char[] middleArray = middle.rotorString.toCharArray();
        char[] outerArray = outer.rotorString.toCharArray();
        char currentInInner = innerArray[0];
        char nextInInner = innerArray[innerArray.length-1];
        char currentInMiddle = middleArray[0];
        char nextInMiddle = middleArray[middleArray.length-1];
      


        //test the first Rotor
        if (nextInInner == inner.firstChar()){
            //test the second Rotor
            if(nextInMiddle == middle.firstChar()){
                outer.rotate();
            }
            middle.rotate();
        }
        inner.rotate();
        }
    }
