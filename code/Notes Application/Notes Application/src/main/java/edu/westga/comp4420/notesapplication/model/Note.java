package edu.westga.comp4420.Note.model;

import java.util.ArrayList;
import java.util.List;

public class Note {
	private String text;
	private List<String> topics;
	private List<Note> notes;
	private Note activeNote;
	
	/**
	 * Default Constructor for the Note Class
	 *
	 * @precondition none
	 * @postcondition none
	 * 
	 * 
	 */
	public Note() {
		this.activeNote = new Note();
		this.notes = new ArrayList<>();
	}
	
	/**
	 * Parametized Constructor for the Note Class
	 *
	 * @precondition none
	 * @postcondition none
	 * 
	 * 
	 * @param text
	 * @param topics
	 *
	 */
	public Note(String text, List<String> topics) {
		this.text = text;
		this.topics = topics;
	}
	
	/**
	 * Will add a blank note to the list of notes.
	 *
	 * @precondition none
	 * @postcondition none
	 * 
	 */
	public void addBlankNote() {
		this.notes.add(new Note());
	}
	
	/**
	 * Will select the current active note to perform modifications
	 *
	 * @precondition none
	 * @postcondition none
	 *
	 * @param index
	 * 
	 */
	public void selectNote(int index) {
		if (index >= 0 && index < this.notes.size()) {
			this.activeNote = this.notes.get(index);
		}
	}
	
	/**
	 * Will update the notes current text
	 *
	 * @precondition none
	 * @postcondition none
	 *
	 * @param newText
	 * 
	 */
	public void updateActiveNote(String newText) {
		if (this.activeNote != null) {
			this.activeNote.setText(newText);
		} else {
			System.out.println("There is not a note that is currently active.");
		}
	}
	
	/**
	 * Will add a topic to the note's topic list
	 *
	 * @precondition topic != isEmpty()
	 * @postcondition none
	 *
	 * @param topic
	 * 
	 */
	public void addTopic(String topic) {
		if (this.activeNote != null) {
			if (!topic.isEmpty() && !this.topics.contains(topic)) {
				this.topics.add(topic);
			}
		} else {
			System.out.println("The topic can not be empty nor duplicated!");
		}
	}
	
	/**
	 * Will remove a topic from the note's topic list
	 *
	 * @precondition none
	 * @postcondition none
	 *
	 * @param topic
	 * 
	 */
	public void removeTopic(String topic) {
		if (this.activeNote != null) {
			this.activeNote.getTopics().remove(topic);
		}
	}
	
	/**
	 * Will remove the current note from the list
	 *
	 * @precondition none
	 * @postcondition none
	 *
	 * 
	 */
	public void removeNote() {
		if (this.activeNote != null) {
			this.notes.remove(this.activeNote);
			this.activeNote = null;
		} else {
			System.out.println("There is not a note that is currently active.");
		}
	}
	
	/**
	 * Getter for text
	 *
	 * @precondition none
	 * @postcondition none
	 *
	 * @return text
	 */
	public String getText() {
		return this.text;
	}		
	
	/**
	 * Setter for text
	 *
	 * @precondition none
	 * @postcondition none
	 *
	 * @param text
	 */
	public void setText(String text) {
		this.text = text;
		
	}
	
	/**
	 * Getter for topics
	 *
	 * @precondition none
	 * @postcondition none
	 *
	 * @return topics
	 */
	public List<String> getTopics() {
		return this.topics;
	}		
	
	/**
	 * Setter for topics
	 *
	 * @precondition none
	 * @postcondition none
	 *
	 * @param topics
	 */
	public void setTopics(List<String> topics) {
		this.topics = topics;
	}
	
	/**
	 * Getter for activeNote
	 *
	 * @precondition none
	 * @postcondition none
	 *
	 * @return activeNote
	 */
	private Note getActiveNote() {
		return this.activeNote;
	}
	
	/**
	 * Setter for topics
	 *
	 * @precondition none
	 * @postcondition none
	 *
	 * @param currNote
	 */
	private void setActiveNote(Note currNote) {
		this.activeNote = currNote;
	}
	
	/**
	 * Getter for notes list 
	 *
	 * @precondition none
	 * @postcondition none
	 *
	 * @return topics
	 */
	public List<Note> getNotes() {
		return this.notes;
	}		
	
	/**
	 * Setter for notes list
	 *
	 * @precondition none
	 * @postcondition none
	 *
	 * @param notes
	 */
	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}
	
}