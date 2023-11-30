public class LAB_2_1 {
    public static void main(String[] args) 
    {
        String text = "We realizes that while our workers were thriving, the surrounding villages were still suffering. It became our goal to uplift their quality of life as well. I remember seeing a family of 4 on a motorbike in the heavy Bombay rain — I knew I wanted to do more for these families who were risking their lives for lack of an alternative. The alternative mentioned here is the Tata Nano, which soon after came as the world’s cheapest car on retail at a starting price of only Rs 1 lakh. These were the words of Ratan Tata in a recent post by Humans of Bombay which formed the basis of his decision to come up with a car like Tata Nano.";
        char character = text.charAt(10);
        System.out.println(character);

        String otherText="humple";
        int compare=text.compareTo(otherText);
        System.out.println(compare);

        String concatResult=text.concat(otherText);
        System.out.println(concatResult);

        boolean containsResult=text.contains("workers");
        System.out.println(containsResult);

        boolean endsWithResult=text.endsWith("THERE");
        System.out.println(endsWithResult);
         
        String otherText1="simple";
        boolean equalsResult=otherText.equals(otherText1);
        System.out.println(equalsResult);

        boolean equalsIgnoreCaseResult=otherText.equalsIgnoreCase(otherText1);
        System.out.println(equalsIgnoreCaseResult);

        String formatResult=String.format(text);
        System.out.println(formatResult);

        byte[] getBytesResult=text.getBytes();
        System.out.println(getBytesResult);

        char[] charArray = new char[10];
        text.getChars(4, 14, charArray, 0);
        System.out.println(charArray);

        int indexOfResult=text.indexOf("Ratan");
        System.out.println(indexOfResult);

        String internResult=text.intern();
        System.out.println(internResult);
        
        boolean isEmptyResult=text.isEmpty();
        System.out.println(isEmptyResult);

        String[] words = text.split(" ");
        String joinedStringResult = String.join("-", words);
        System.out.println(joinedStringResult);

        int lastIndexOfResult=text.lastIndexOf("the");
        System.out.println(lastIndexOfResult);

        int lengthResult=text.length();
        System.out.println(lengthResult);

        String replaceResult=text.replace("Tata","Auto");
        System.out.println(replaceResult);

        String replaceAllResult=text.replaceAll("The","ooooook");
        System.out.println(replaceAllResult);

        String[] splitString = text.split(" ");
        for (String word : splitString) {
            System.out.println(word);
        }

        boolean startsWithResult=text.startsWith("my");
        System.out.println(startsWithResult);

        String substringResult=text.substring(1,5);
        System.out.println(substringResult);

        char[] charArray2 = text.toCharArray();
        System.out.println(charArray2);

        String toLowerCaseResult=text.toLowerCase();
        System.out.println(toLowerCaseResult);

        String toUpperCaseResult=text.toUpperCase();
        System.out.println(toUpperCaseResult);

        String trimResult=text.trim();
        System.out.println(trimResult);

        String valueOfResult=text.valueOf(lengthResult);
        System.out.println(valueOfResult);
    }
}
