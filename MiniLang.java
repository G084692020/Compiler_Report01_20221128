import java.util.ArrayList;
import java.util.Scanner;

public class MiniLang {

    public static void main(String[] args) {
        new MiniLang();
    }

    MiniLang() {
        boolean showTokenResults = true;
        boolean debug = false;

        ArrayList<String> stdin = new ArrayList<String>();
        Scanner scn = new Scanner(System.in);
        while (true) {
            System.out.print(">>>>");
            String token = scn.nextLine();
            if (debug)
                System.out.println("input:" + token);
            if (token.length() != 0) {
                if (token.contains("exit"))
                    break;
                token = returnTokens(token);
                if (showTokenResults)
                    System.out.println(token);
                if (!(token.contains("Syntax Error")))
                    stdin.add(token);
            }
        }
        scn.close();
    }

    private static String returnTokens(String input) {
        String result = "";
        String inputToken = "";
        for (int i = 0; i < input.length(); i++) {
            inputToken += input.charAt(i);
            if (inputToken.contains("int")) {
                result += "int: ";
                for (i++; i < input.length(); i++) {
                    if (input.charAt(i) >= 'a' && 'z' >= input.charAt(i)) {
                        result += input.charAt(i);
                        for (i++; i < input.length(); i++) {
                            if (input.charAt(i) >= '0' && '9' >= input.charAt(i)
                                    || input.charAt(i) >= 'a' && 'z' >= input.charAt(i))
                                result += input.charAt(i);
                            else if (input.charAt(i) != ' ') {
                                return "Syntax Error at: " + input.substring(0, i) + "\"\"" + input.substring(i)
                                        + "\"\"";
                            }
                        }
                    } else if (input.charAt(i) != ' ' && input.charAt(i) >= '0' && '9' >= input.charAt(i)) {
                        return "Syntax Error at: " + input.substring(0, i) + "\"\"" + input.substring(i)
                                + "\"\"";
                    }
                }
            } else if (inputToken.contains("long")) {
                result += "long: ";
                for (i++; i < input.length(); i++) {
                    if (input.charAt(i) >= 'a' && 'z' >= input.charAt(i)) {
                        result += input.charAt(i);
                        for (i++; i < input.length(); i++) {
                            if (input.charAt(i) >= '0' && '9' >= input.charAt(i)
                                    || input.charAt(i) >= 'a' && 'z' >= input.charAt(i))
                                result += input.charAt(i);
                            else if (input.charAt(i) != ' ') {
                                return "Syntax Error at: " + input.substring(0, i) + "\"\"" + input.substring(i)
                                        + "\"\"";
                            }
                        }
                    } else if (input.charAt(i) != ' ' && input.charAt(i) >= '0' && '9' >= input.charAt(i)) {
                        return "Syntax Error at: " + input.substring(0, i) + "\"\"" + input.substring(i)
                                + "\"\"";
                    }
                }
            } else if (inputToken.contains("double")) {
                result += "long: ";
                for (i++; i < input.length(); i++) {
                    if (input.charAt(i) >= 'a' && 'z' >= input.charAt(i)) {
                        result += input.charAt(i);
                        for (i++; i < input.length(); i++) {
                            if (input.charAt(i) >= '0' && '9' >= input.charAt(i)
                                    || input.charAt(i) >= 'a' && 'z' >= input.charAt(i))
                                result += input.charAt(i);
                            else if (input.charAt(i) != ' ') {
                                return "Syntax Error at: " + input.substring(0, i) + "\"\"" + input.substring(i)
                                        + "\"\"";
                            }
                        }
                    } else if (input.charAt(i) != ' ' && input.charAt(i) >= '0' && '9' >= input.charAt(i)) {
                        return "Syntax Error at: " + input.substring(0, i) + "\"\"" + input.substring(i)
                                + "\"\"";
                    }
                }
            } else if (input.charAt(i) >= '0' && '9' >= input.charAt(i) || input.charAt(i) == '.') {
                boolean isDouble = false;
                inputToken = "";
                // boolean isNumber = false;
                if (input.charAt(i) == '.') {
                    inputToken = "0.";
                    isDouble = true;
                }
                for (; i < input.length(); i++) {
                    if (input.charAt(i) >= '0' && '9' >= input.charAt(i))
                        inputToken += input.charAt(i);
                    else if (input.charAt(i) == '.') {
                        if (isDouble) {
                            return "Syntax Error at: " + input.substring(0, i) + "\"\"" + input.substring(i)
                                    + "\"\"";
                        }
                        isDouble = true;
                        inputToken += input.charAt(i);
                    } else if (input.charAt(i) == '+') {
                        if (inputToken.length() != 0) {
                            result += ((isDouble ? "小数" : "整数") + ": " + inputToken + ", 記号: +, ");
                            inputToken = "";
                            isDouble = false;
                        }
                    } else if (input.charAt(i) == '-') {
                        if (inputToken.length() != 0) {
                            result += ((isDouble ? "小数" : "整数") + ": " + inputToken + ", 記号: -, ");
                            inputToken = "";
                            isDouble = false;
                        }
                    } else if (input.charAt(i) == '*') {
                        if (inputToken.length() != 0) {
                            result += ((isDouble ? "小数" : "整数") + ": " + inputToken + ", 記号: -, ");
                            inputToken = "";
                            isDouble = false;
                        }
                    } else if (input.charAt(i) == '/') {
                        if (inputToken.length() != 0) {
                            result += ((isDouble ? "小数" : "整数") + ": " + inputToken + ", 記号: -, ");
                            inputToken = "";
                            isDouble = false;
                        }
                    } else if (input.charAt(i) != ' ') {
                        return "Syntax Error at: " + input.substring(0, i) + "\"\"" + input.substring(i)
                                + "\"\"";
                    }
                    // else if (input.charAt(i)==' '){
                    // for(i++; i < input.length(); i++){
                    // if(input.charAt(i)!=' '){
                    // return "Syntax Error at: " + input.substring(0, i) + "\"\"" +
                    // input.substring(i)
                    // + "\"\"";
                    // }
                    // }
                    // break;
                    // }
                }
                if (inputToken.matches("0.")) {
                    return "Syntax Error";
                }
                if (inputToken.length() != 0) {
                    result += ((isDouble ? "小数" : "整数") + ": " + inputToken);
                    inputToken = "";
                    isDouble = false;
                }

            }
        }

        return result;
    }
}
