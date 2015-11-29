#include <security/pam_appl.h>
#include <security/pam_misc.h>
#include <pwd.h>
#include <sys/types.h>
#include <stdio.h>
//#define MY_CONFIG "su"
static struct pam_conv conv = {
    misc_conv,
    NULL
};

int main(int argc, char **argv) {
	pam_handle_t *pamh = NULL;
	int retval;
	const char *user = "nobody";
	const char *path = "";

	if (argc == 3) {
		user = argv[1];
		path = argv[2];
	}

	if (argc != 3) {
		fprintf(stderr, "Uso: MontyPluginAuthentication [username] [app]\n");
		exit(1);
	}

	retval = pam_start("MontyPluginAuthentication", user, &conv, &pamh);

	if (retval == PAM_SUCCESS)
		retval = pam_authenticate(pamh, 0); /* Verificación de usuario */

	if (retval == PAM_SUCCESS) {
		fprintf(stdout, "Autenticado %s\n",user);
		char str[255];
		strcpy(str, "java -jar ");
		strcat(str, path);
		system(str);
	} else {
		fprintf(stdout, "No Autenticado\n");
	}

	if (pam_end(pamh, retval) != PAM_SUCCESS) { /* close Linux-PAM */
		pamh = NULL;
		fprintf(stderr, "MontyPluginAuthentication: fallo al finalizar\n");
		exit(1);
	}
	return (retval == PAM_SUCCESS ? 0 : 1); /* indicate success */
}
