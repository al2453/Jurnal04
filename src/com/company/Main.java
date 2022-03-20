package com.company;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

        public static void pilihan(){
            System.out.println(" -------- Please select -------- ");
            System.out.println(" 1. Enter song ");
            System.out.println(" 2. Delete song ");
            System.out.println(" 3. Play song ");
            System.out.println(" 4. Exit ");
        }

        public static void main(String[] args) {
            // write your code here
            LinkedList<PlayList> playListLagu = new LinkedList<PlayList>();
            Scanner in = new Scanner(System.in);
            boolean condition = true;

            while (condition){
                pilihan();
                switch (in.nextInt()){
                    case 1 :
                        String songTitle = in.next();
                        String singer = in.next();
                        playListLagu.addLast(new PlayList(songTitle,singer));
                        break;
                    case 2 :
                        System.out.println("1. Delete last song");
                        System.out.println("2. Delete songs by title");
                        int hapus = in.nextInt();
                        if (hapus == 1){
                            playListLagu.removeLast();
                        }else if ( hapus == 2) {
                            String hapusJudul = in.next();
                            removeByTitle(playListLagu, hapusJudul);}
                        break;
                    case 3 :
                        print(playListLagu);
                        break;
                    default:
                        condition = false;
                        break;
                }
            }
        }

        private static void print(LinkedList<PlayList> playListLagu) {
            ListIterator<PlayList>iterator = playListLagu.listIterator();

            while (iterator.hasNext()){
                if (iterator.hasPrevious()){
                    System.out.print(", "+iterator.next());
                }
                else {
                    System.out.print(iterator.next());
                }
            }
            iterator.previous();
            while (iterator.hasPrevious()){
                System.out.print(", "+ iterator.previous());
            }
            System.out.println();
        }

        public static void removeByTitle(LinkedList<PlayList> playListLagu, String hapusJudul) {
            ListIterator<PlayList> iterator = playListLagu.listIterator();

            while (iterator.hasNext()){
                PlayList playList = iterator.next();
                if (playList.getSong().equalsIgnoreCase(hapusJudul)){
                    iterator.remove();
                }
            }
        }
    }