package com.YiShun.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lanly on 2018/6/27 下午7:28
 */

public class FFMpegTest {

    private String ffmpegEXE;

    public FFMpegTest(String ffmpegEXE) {
        super();
        this.ffmpegEXE = ffmpegEXE;
    }

    public void convertor(String videoInputPath, String videoOutputPath) throws Exception {

        List<String> command = new ArrayList<>();
        command.add(ffmpegEXE);

        command.add("-i");
        command.add(videoInputPath);
        command.add(videoOutputPath);

        for (String c : command) {
            System.out.print(c);
        }

        ProcessBuilder builder = new ProcessBuilder(command);
        Process process = builder.start();

        InputStream errorStream = process.getErrorStream();
        InputStreamReader inputStreamReader = new InputStreamReader(errorStream);
        BufferedReader br = new BufferedReader(inputStreamReader);

        String line = "";
        while ((line = br.readLine()) != null) {

        }

        if (br != null) {
            br.close();
        }
        if (inputStreamReader != null) {
            inputStreamReader.close();
        }
        if (errorStream != null) {
            errorStream.close();
        }

    }

    public static void main(String[] args) {
        FFMpegTest ffmpeg = new FFMpegTest("/usr/local/Cellar/ffmpeg/4.0.1/bin/ffmpeg");
        try {
            ffmpeg.convertor("/usr/local/YiShunCache/before.mp4","/usr/local/YiShunCache/after.avi");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
