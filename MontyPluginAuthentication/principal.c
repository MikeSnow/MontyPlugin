#include <security/pam_appl.h>
#include <security/pam_misc.h>
#include <pwd.h>
#include <sys/types.h>
#include <stdio.h>
#define MY_CONFIG "su"
static struct pam_conv conv = {
    misc_conv,
    NULL
};

int main(int argc, char **argv) {
	pam_handle_t *pamh = NULL;
	int retval;
	const char *user = "nobody";

	if (argc == 2) {
		user = argv[1];
	}

	if (argc > 2) {
		fprintf(stderr, "Usage: check_user [username]\n");
		exit(1);
	}

	retval = pam_start("check_user", user, &conv, &pamh);

	if (retval == PAM_SUCCESS)
		retval = pam_authenticate(pamh, 0); /* is user really user? */

	/* This is where we have been authorized or not. */

	if (retval == PAM_SUCCESS) {
		fprintf(stdout, "Authenticated %s\n",user);
	} else {
		fprintf(stdout, "Not Authenticated\n");
	}

	if (pam_end(pamh, retval) != PAM_SUCCESS) { /* close Linux-PAM */
		pamh = NULL;
		fprintf(stderr, "check_user: failed to release authenticator\n");
		exit(1);
	}
	if(retval == PAM_SUCCESS ){
		system("java -jar /home/juanruiz/MontyPlugin.jar");
	}
	return (retval == PAM_SUCCESS ? 0 : 1); /* indicate success */
}
