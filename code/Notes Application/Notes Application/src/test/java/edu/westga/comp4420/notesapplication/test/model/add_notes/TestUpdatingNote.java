package edu.westga.comp4420.notesapplication.test.model.add_notes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

import edu.westga.comp4420.notesapplication.model.Note;


class TestUpdatingNotes{
	
	private Note blankNote;

    @Before
    public void setUp() {
        blankNote = new Note();
    }
	
	@Test
    public void testUpdateNote() {
        blankNote.addBlankNote();
        blankNote.selectNote(0);
        blankNote.updateActiveNote("Updated text");
        assertEquals("Updated text", blankNote.getActiveNote().getText());
    }
	
}
