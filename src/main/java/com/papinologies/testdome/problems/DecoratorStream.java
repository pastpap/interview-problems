package com.papinologies.testdome.problems;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class DecoratorStream extends OutputStream {
    private OutputStream stream;
    private String prefix;
    private boolean isPrefixWritten = false; // Flag to check if the prefix has been written

    public DecoratorStream(OutputStream stream, String prefix) {
        super();
        this.stream = stream;
        this.prefix = prefix;
    }

    @Override
    public void write(int b) throws IOException {
        byte[] result = new byte[4];

        result[0] = (byte) (b >> 24);
        result[1] = (byte) (b >> 16);
        result[2] = (byte) (b >> 8);
        result[3] = (byte) (b);

        write(result, 0, 4);
    }

    /**
     * Flag Initialization (isPrefixWritten): We add a boolean flag,
     * isPrefixWritten, initialized to false. This flag is used to keep track of
     * whether the prefix has already been written to the stream.
     * 
     * Check and Write Prefix: Inside the write(byte[] b, int off, int len) method,
     * we first check if isPrefixWritten is false. If it is, we write the prefix to
     * the stream using stream.write(prefix.getBytes("UTF-8")) to ensure the prefix
     * is written in UTF-8 encoding. After writing, we set isPrefixWritten to true.
     * 
     * Write Data: After the prefix check, we directly write the provided bytes to
     * the underlying stream with stream.write(b, off, len).
     * 
     * Main Method: The main method demonstrates the use of DecoratorStream by
     * writing a byte array message and confirming that the prefix and message are
     * correctly output.
     * 
     * This solution ensures the prefix is written only once and all bytes received
     * in the write methods are correctly forwarded to the underlying OutputStream.
     */
    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        // Write the prefix if it hasn't been written yet
        if (!isPrefixWritten) {
            stream.write(prefix.getBytes("UTF-8")); // Convert prefix to bytes using UTF-8 encoding
            isPrefixWritten = true; // Mark prefix as written
        }

        // Write the provided bytes to the underlying stream
        stream.write(b, off, len);
    }

    @Override
    public void write(byte[] b) throws IOException {
        write(b, 0, b.length);
    }

    public static void main(String[] args) throws IOException {
        byte[] message = new byte[] { 0x48, 0x65, 0x6c, 0x6c, 0x6f, 0x2c, 0x20, 0x77, 0x6f, 0x72, 0x6c, 0x64, 0x21 };
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            DecoratorStream decoratorStream = new DecoratorStream(baos, "First line: ");
            decoratorStream.write(message);

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(new ByteArrayInputStream(baos.toByteArray()), "UTF-8"))) {
                System.out.println(reader.readLine()); // should print "First line: Hello, world!"
            }

            decoratorStream.close();
        }
    }
}