public class StringCompression {
    public int compress(char[] chars) {
        int readIndex = 0;
        int writeIndex = 0;

        while (readIndex < chars.length) {
            int j = readIndex;
            while (j < chars.length && chars[j] == chars[readIndex]) {
                j++;
            }
            chars[writeIndex] = chars[readIndex];
            writeIndex++;

            if (j - readIndex > 1) {
                String countStr = Integer.toString(j - readIndex);
                for (char c : countStr.toCharArray()) {
                    chars[writeIndex] = c;
                    writeIndex++;
                }
            }
            readIndex = j;
        }
        return writeIndex;
    }

    public static void main(String[] args) {
        StringCompression sc = new StringCompression();
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int newLength = sc.compress(chars);
        System.out.println("Compressed Length: " + newLength);
        System.out.print("Compressed Chars: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(chars[i]);
        }
    }
}
