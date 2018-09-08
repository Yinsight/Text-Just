package TextJustification;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Question3 {

	public static void justify(String[] W, int w, ArrayList<Integer> L) throws IOException {
		// creates a text file ¡°just.txt¡±
		File file = new File("just.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// file InputStream.
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));

		// print words and spaces.
		for (int i = 0; i < L.size(); i++) {

			// get the indices x,y
			// x is the head of split point, y is the next split point
			int x = L.get(i);
			int y;
			if (i == L.size() - 1)
				y = W.length;
			else
				y = L.get(i + 1);

			// spaces is the all spaces' number.
			int spaces = w - Question1.l(W, x, y) + y - x - 1;
			
			// use '/' and '%' operation to average the spaces' number between words.
			int consult;
			int remainder;
			if ((y - x) == 1) {
				remainder = 0;
				consult = 0;
			} else {
				consult = spaces / (y - x - 1);
				remainder = spaces % (y - x - 1);
			}

			remainder += x;

			// use the W[] words and the spaces numbers that calculated in the above product the string of one line
			String str = new String();
			str += W[x];
			while (x < y - 1) {
				for (int a = 0; a < consult; a++) {
					str += " ";
				}
				if (x < remainder)
					str += " ";

				x++;
				str += W[x];
			}
			// writet the str into the file "just.txt"
			bw.write(str);
			bw.newLine();
		}
		// close the file InputStream.
		bw.close();
	}
}