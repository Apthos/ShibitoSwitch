package net.kevin.files;

import net.kevin.Main;

import java.io.*;

public class DeadFile {

    public DeadFile(File file) {
        interpret(read(file));
        Main.say("File Binary String Conversion : "
                + new String(readAlternateImpl(file.getAbsolutePath())));
    }

    public DeadFile() {
        Main.warn("Created a blank shb file!");
    }

    byte[] read(File file) {
        byte[] result = new byte[(int) file.length()];
        try {
            InputStream input = null;
            try {
                int totalBytesRead = 0;
                input = new BufferedInputStream(new FileInputStream(file));
                while (totalBytesRead < result.length) {
                    int bytesRemaining = result.length - totalBytesRead;
                    int bytesRead = input.read
                            (result, totalBytesRead, bytesRemaining);
                    Main.report("READING :" + new String(result));
                    if (bytesRead > 0) {
                        totalBytesRead = totalBytesRead + bytesRead;
                    }
                }
                Main.say("Num bytes read: " + totalBytesRead);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                Main.warn("Closing input stream.");
                input.close();
            }
        } catch (FileNotFoundException ex) {
            Main.say("File not found.");
        } catch (IOException ex) {
            Main.say(ex.toString());
        }
        return result;
    }

    byte[] interpret(byte[] bytes) {
        for (byte Byte : bytes){
            System.out.println(Byte);
        }

        return null;
    }

    void write(byte[] aInput, String aOutputFileName) {
        Main.say("Writing binary file...");
        try {
            OutputStream output = null;
            try {
                output = new BufferedOutputStream
                        (new FileOutputStream(aOutputFileName));
                output.write(aInput);
            } finally {
                output.close();
            }
        } catch (FileNotFoundException ex) {
            Main.warn("File not found.");
        } catch (IOException ex) {
            Main.warn(ex.toString());
        }
    }

    /**
     * Read the given binary file, and return its contents as a byte array.
     */
    byte[] readAlternateImpl(String aInputFileName) {
        Main.warn("Reading in binary file named : " + aInputFileName);
        File file = new File(aInputFileName);
        Main.warn("File size: " + file.length());
        byte[] result = null;
        try {
            InputStream input = new BufferedInputStream(new FileInputStream(file));
            result = readAndClose(input);
        } catch (FileNotFoundException ex) {
            Main.warn(ex.toString());
        }
        return result;
    }

    /**
     * Read an input stream, and return it as a byte array.
     * Sometimes the source of bytes is an input stream instead of a file.
     * This implementation closes aInput after it's read.
     */
    byte[] readAndClose(InputStream aInput) {
        //carries the data from input to output :
        byte[] bucket = new byte[32 * 1024];
        ByteArrayOutputStream result = null;
        try {
            try {
                //Use buffering? No. Buffering avoids costly access to disk or network;
                //buffering to an in-memory stream makes no sense.
                result = new ByteArrayOutputStream(bucket.length);
                int bytesRead = 0;
                while (bytesRead != -1) {
                    //aInput.read() returns -1, 0, or more :
                    bytesRead = aInput.read(bucket);
                    if (bytesRead > 0) {
                        result.write(bucket, 0, bytesRead);
                    }
                    Main.report(new String(result.toByteArray()));
                }
            } finally {
                aInput.close();
                //result.close(); this is a no-operation for ByteArrayOutputStream
            }
        } catch (IOException ex) {
            Main.warn(ex.toString());
        }
        return result.toByteArray();
    }

}
