package com.papinologies.testdome.problems;

public class Song {
    @SuppressWarnings("unused")
    private String name;
    private Song nextSong;

    public Song(String name) {
        this.name = name;
    }

    public void setNextSong(Song nextSong) {
        this.nextSong = nextSong;
    }

    /**
     * Floyd's Cycle Detection Algorithm (also known as the Tortoise and Hare
     * algorithm)
     * 
     * Slow and Fast Pointers:
     * 
     * The slow pointer moves one step at a time.
     * The fast pointer moves two steps at a time.
     * Cycle Detection:
     * 
     * If there is a cycle in the linked list, the slow and fast pointers will
     * eventually meet.
     * If there is no cycle, the fast pointer will reach the end (null).
     * Edge Cases:
     * 
     * If the playlist has only one song and doesn't point to itself, return false.
     * If the nextSong of any node is null, there is no cycle.
     * 
     * @return
     */
    public boolean isInRepeatingPlaylist() {
        Song slow = this;
        Song fast = this;

        while (fast != null && fast.nextSong != null) {
            slow = slow.nextSong; // Move slow pointer by 1 step
            fast = fast.nextSong.nextSong; // Move fast pointer by 2 steps

            if (slow == fast) {
                return true; // A cycle is detected
            }
        }

        return false; // No cycle found
    }

    public static void main(String[] args) {
        Song first = new Song("Hello");
        Song second = new Song("Eye of the tiger");

        first.setNextSong(second);
        second.setNextSong(first);

        System.out.println(first.isInRepeatingPlaylist());
    }
}