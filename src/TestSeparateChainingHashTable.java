/***************************************************************************
 @file: Proj4.java
 @description: This program implements the test main class for a Separate Chaining Hash table.
 @author:  Kennedy Kirk
 @date  Dec 3 ,2024
 // hello
 *******************************************************************************/

public class TestSeparateChainingHashTable {
    public static void main( String [ ] args ) {
        SeparateChainingHashTable<Integer> H = new SeparateChainingHashTable<>( );

        long startTime = System.currentTimeMillis( );

        final int NUMS = 2000000; //
        final int GAP  =   37; // GAP is the step size

        System.out.println( "Checking... (no more output means success)" );

        // Insert NUMS keys, but only NUMS/2 distinct keys
        for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS )
            H.insert( i );

        // Remove the even numbers
        for( int i = 1; i < NUMS; i+= 2 )
            H.remove( i );

        // Test if the even numbers are still there
        for( int i = 2; i < NUMS; i+=2 )
            if( !H.contains( i ) )
                System.out.println( "Find fails " + i );

        // Test if the odd numbers are still there
        for( int i = 1; i < NUMS; i+=2 ) {
            if( H.contains( i ) )
                System.out.println( "OOPS!!! " +  i  );
        }

        long endTime = System.currentTimeMillis( );

        System.out.println( "Elapsed time: " + (endTime - startTime) );
    }
}
