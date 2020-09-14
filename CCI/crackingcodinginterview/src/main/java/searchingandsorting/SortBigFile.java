package searchingandsorting;

public class SortBigFile {
    /*
    * Question : Sort Big File: Imagine you have a 20 GB file with one string per line.
    * Explain how you would sort the file.
    *
    * Solution :
    * I can divide the file in 20 chunks and sort those chunks individually,
    * now when all those chunks are sorted I can take 20 buffers and like merge sort's
    * merge method we can fill the sorted 20 GB files by keeping the pointers overs
    * these buffers, once a buffer is emptied then it will get the data from its chunk
    * and if chunk is empty then we will remove that buffer.
    *
    * */
}
