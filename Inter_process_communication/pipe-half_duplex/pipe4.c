#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>
#include <sys/wait.h>
#include <string.h>
//passing array through pipe

int main(){
    int pfd[2];
    int cfork;

    if (pipe(pfd) == -1) {
        exit(1);
    }

    cfork = fork();

if (cfork == -1) {
        printf("Fork Failed\n");
        exit(1);
    }
    else if (cfork == 0) {

        int numbers[] = {
            1, 2,
            3, 4
        };

        int limit = 4;
        close(pfd[0]);
        int i;
        for ( i = 0; i < limit; i++) {
            printf("Child - Current Number: %d\n", numbers[i]);
            write(pfd[1], &numbers[i], sizeof(numbers[i]));
        }
        close(pfd[1]);
        _exit(0);
    }
    else {

        int temp,i;
        int reads = 4;
        close(pfd[1]);
        for (i = 0; i < reads; i++) {
            read(pfd[0], &temp, sizeof(temp));
            printf("Parent - Number Fetched: %d\n", temp);
        }
        close(pfd[0]);
        waitpid(-1, NULL, 0);
    }

    return 0;
}
