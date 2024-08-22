package com.example;

import java.io.File;

public class App {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java -jar smaf-converter.jar <input.smaf> <output.midi>");
            return;
        }
        String smafFilePath = args[0];
        String midiFilePath = args[1];

        try {
            File smafFile = new File(smafFilePath);
            vavi.sound.smaf.Sequence smafSequence = vavi.sound.smaf.SmafSystem.getSequence(smafFile);

            // Convert SMAF sequence to MIDI sequence
            javax.sound.midi.Sequence midiSequence = vavi.sound.smaf.SmafSystem.toMidiSequence(smafSequence);

            // Write the MIDI sequence to a file
            File midiFile = new File(midiFilePath);
            javax.sound.midi.MidiSystem.write(midiSequence, 1, midiFile);

            System.out.println("SMAF to MIDI conversion successful.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}