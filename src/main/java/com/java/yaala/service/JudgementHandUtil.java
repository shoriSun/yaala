
package com.java.yaala.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.java.yaala.bean.Card;

public class JudgementHandUtil {

    public static boolean judgementTwoPair(Card[] cards) {
        int count = 0;
        boolean result = false;
        List<Card> pairCard = new ArrayList<Card>();
        for(Card card1 : cards) {
            for(Card card2 : cards) {
                if(!card1.equals(card2) && !pairCard.contains(card1) && !pairCard.contains(card2)) {
                    if(card1.getNumber() == card2.getNumber()) {
                        count++;
                        pairCard.add(card1);
                        pairCard.add(card2);
                    }
                }
            }
        }
        if(count == 2) {
            result = true;
        }
        return result;
    }
    
    public static boolean judgementThreeCard(Card[] cards) {
        boolean result = false;
        for(Card card1 : cards) {
            int count = 0;
            for(Card card2 : cards) {
                if(!card1.equals(card2)) {
                    if(card1.getNumber() == card2.getNumber()) {
                        count++;
                    }
                }
            }
            if(count >= 2) {
                result = true;
                break;
            }
        }
        return result;
    }
    
    public static boolean judgementOnePair(Card[] cards) {
        int count = 0;
        boolean result = false;
        List<Card> pairCard = new ArrayList<Card>();
        for(Card card1 : cards) {
            for(Card card2 : cards) {
                if(!card1.equals(card2) && !pairCard.contains(card1) && !pairCard.contains(card2)) {
                    if(card1.getNumber() == card2.getNumber()) {
                        count++;
                        pairCard.add(card1);
                        pairCard.add(card2);
                        break;
                    }
                }
            }
        }
        if(count == 1) {
            result = true;
        }
        return result;
    }
    
    public static boolean judgementFourCard(Card[] cards) {
        boolean result = false;
        for(Card card1 : cards) {
            int count = 0;
            for(Card card2 : cards) {
                if(!card1.equals(card2)) {
                    if(card1.getNumber() == card2.getNumber()) {
                        count++;
                    }
                }
            }
            if(count >= 3) {
                result = true;
                break;
            }
        }
        return result;
    }
    
    public static boolean judgementFullHouse(Card[] cards) {
        boolean result = false;
        if (judgementTwoPair(cards) && judgementThreeCard(cards)) {
            result = true;
        }
        return result;
    }
    
    public static boolean judgementStraight(Card[] cards) {
        boolean result = true;

        List<Integer> numbers = new ArrayList<Integer>();
        for (Card card : cards) {
            numbers.add(card.getNumber());
        }

        Collections.sort(numbers);

        for (int i = 0; i < numbers.size() -1; i++) {
    		if (numbers.get(i) + 1 != numbers.get(i + 1)) {
    			result = false;
                break;
    		}
    	}

        return result;
    }
    
    public static boolean judgementFlash(Card[] cards) {
        boolean result = true;

        int firstMark = cards[0].getMark();
        for (Card card : cards) {
            if (firstMark != card.getMark()) {
                result = false;
                break;
            }
        }

        return result;
    }
    
    public static boolean judgementStraightFlash(Card[] cards) {
        boolean result = false;
        if(judgementStraight(cards) && judgementFlash(cards)){
            result = true;
        }
        return result;
    }
    
    public static boolean judgementSunshine(Card[] cards) {
        boolean result = false;
        return result;
    }
    
    public static boolean judgementTwinSun(Card[] cards) {
        boolean result = false;
        return result;
    }
    
    public static boolean judgementStarFlash(Card[] cards) {
        boolean result = false;
        if(judgementFlash(cards) && cards[0].getMark() == 4){
            result = true;
        }
        return result;
    }
    
    public static boolean judgementDiaHouse(Card[] cards) {
        boolean result = false;
        return result;
    }
    
    public static boolean judgementSpadeLeader(Card[] cards) {
        boolean result = false;
        return result;
    }
    
    public static boolean judgementSpadeDiaMix(Card[] cards) {
        boolean result = false;
        boolean isSpadeDiaMix = false;

        List<Integer> marks = new ArrayList<Integer>();
        for (Card card : cards) {
            marks.add(card.getMark());
        }
        isSpadeDiaMix = contaionsSpadeDiaMix(marks);
        return result;
    }
    
    public static boolean judgementMarkWonder(Card[] cards) {
        boolean result = false;
        return result;
    }
    
    public static boolean judgementSunArch(Card[] cards) {
        boolean result = false;
        // 記号が太陽であること
        // ストレートであること〇
        // フラッシュであること〇
        if(judgementStraightFlash(cards) && cards[0].getMark() == 1){
            result = true;
        }
        return result;
    }

    private static boolean contaionsSpadeDiaMix(List<Integer> marks) {
        List<Integer> targetMarks = List.of(2, 3);

        if (marks.contains(1) || marks.contains(4)) {
            return false;
        }

        if (!marks.containsAll(targetMarks)) {
            return false;
        }

        return true;
    }
}
