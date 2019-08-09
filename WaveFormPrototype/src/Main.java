import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    static WAVInformation parseWAVInformation(String wavFilePath) {
        WAVInformation result = null;
        File file = new File(wavFilePath);
        try {
            FileInputStream inputStream = new FileInputStream(file);
            WAVInformation wavInformation = new WAVInformation();

            byte[] bHeader = inputStream.readNBytes(4);
            wavInformation.setHeader(BinaryTools.constructString(bHeader));

            byte[] bChunksSize = inputStream.readNBytes(4);
            wavInformation.setChunksSize(BinaryTools.constructInt32(bChunksSize));

            byte[] bWaveId = inputStream.readNBytes(4);
            wavInformation.setWaveId(BinaryTools.constructString(bWaveId));

            result = wavInformation;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void main(String[] args) {
        String wavFilePath = "TestFiles/Test01.wav";
        WAVInformation wavInformation = parseWAVInformation(wavFilePath);

        if (wavInformation == null) {
            System.out.println("Error parsing the WAV file.");
        } else {
            System.out.println(wavInformation.getHeader());
            System.out.println(wavInformation.getChunksSize());
            System.out.println(wavInformation.getWaveId());
        }
    }
}
