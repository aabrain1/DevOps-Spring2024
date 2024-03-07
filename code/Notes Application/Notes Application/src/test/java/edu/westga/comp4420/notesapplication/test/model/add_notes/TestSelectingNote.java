package edu.westga.comp4420.notesapplication.test.model.add_notes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

import edu.westga.comp4420.notesapplication.model.Note;


class TestSelectingNotes {
	
	private Note blankNote;

    @Before
    public void setUp() {
        blankNote = new Note();
    }
	
	 @Test
    public void testSelectNote() {
        blankNote.addBlankNote();
        blankNote.addBlankNote();
        blankNote.selectNote(1);
        assertNotNull(blankNote.getActiveNote());
        assertEquals("", blankNote.getActiveNote().getText());
    }
	
}
