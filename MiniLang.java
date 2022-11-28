import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MiniLang {
    String line;
    int lineIndex = -1;

    public static void main(String[] args) {
        new MiniLang();
    }

    /***
     * 整数の足し算、変数の宣言が出来るミニ言語を実行できる処理系を実装する。
     * 一行にある演算子は多くて1つまで
     * 解析したトークン列を出力する
     * 例
     * int x
     * double y
     * 1 + 2
     * 2.3 + 9.0
     * 今回は簡単にするために次の仮定を置く。
     * 1. 一行で一つのプログラムを書く。一つのプログラムを複数行で書くことは許さない
     * 2. 改行がプログラムの終了点を表す。つまり、改行がJavaのセミコロンに該当する。
     */
    MiniLang() {
        var stdin = new BufferedReader(new InputStreamReader(System.in));
        // 標準入力を1行ずつ読み出す。
        System.out.print(">>");
        try {
            while ((this.line = stdin.readLine()) != null) {
                this.lineIndex = -1;
                // 字句解析でトークンを抽出する
                ArrayList<ArrayList<String>> tokens = lex();

                // 字句解析の結果を出力する
                System.out.println(tokens);

                // 次のプログラムを読みだす
                System.out.print(">>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /***
     * 文字列からトークンを抽出し、その種類と併せて結果を返戻する。
     * 例
     * 入力：23 + 2
     * 出力：(23, 整数）、（+, 記号）、（2, 整数）
     *
     * @return
     */
    ArrayList<ArrayList<String>> lex() {
        ArrayList<ArrayList<String>> tokens = new ArrayList<ArrayList<String>>();

        return tokens;
    }

    char nextChar() {
        if (this.lineIndex + 1 == this.line.length()) {
            return Character.MIN_VALUE;
        } else {
            this.lineIndex++;
            char[] c = this.line.toCharArray();
            return c[this.lineIndex];
        }
    }

}