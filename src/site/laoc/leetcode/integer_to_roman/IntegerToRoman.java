package site.laoc.leetcode.integer_to_roman;

public class IntegerToRoman {

    public String intToRoman(int num) {
        String roman = "";

        int thous = num / 1000;
        int thousLeft = num % 1000;

        if(thous != 0){
            for(int i = 0;i < thous;i++){
                roman = roman + "M";
            }
        }

        int hand = thousLeft / 100;
        int handLeft = thousLeft % 100;

        if(hand > 0 && hand < 4){
            for(int i = 0;i < hand;i++){
                roman = roman + "C";
            }
        }else if(hand == 4){
            roman = roman + "CD";
        }else if(hand >= 5 && hand <= 8){
            roman = roman + "D";
            for(int i = hand - 5; i > 0;i--){
                roman = roman + "C";
            }
        }else if(hand == 9){
            roman = roman + "CM";
        }

        int ten = handLeft / 10;
        int tenLeft = handLeft % 10;

        if(ten > 0 && ten < 4){
            for(int i = 0;i < ten;i++){
                roman = roman + "X";
            }
        }else if(ten == 4){
            roman = roman + "XL";
        }else if(ten >= 5 && ten <= 8){
            roman = roman + "L";
            for(int i = ten - 5; i > 0;i--){
                roman = roman + "X";
            }
        }else if(ten == 9){
            roman = roman + "XC";
        }


        if(tenLeft > 0 && tenLeft < 4){
            for(int i = 0;i < tenLeft;i++){
                roman = roman + "I";
            }
        }else if(tenLeft == 4){
            roman = roman + "IV";
        }else if(tenLeft >= 5 && tenLeft <= 8){
            roman = roman + "V";
            for(int i = tenLeft - 5; i > 0;i--){
                roman = roman + "I";
            }
        }else if(tenLeft == 9){
            roman = roman + "IX";
        }

        return roman;
    }

    public static void main(String [] args){
        IntegerToRoman integerToRoman = new IntegerToRoman();
        System.out.println(integerToRoman.intToRoman(1994));
    }
}
