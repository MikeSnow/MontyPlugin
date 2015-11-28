#include <security/pam_appl.h>

int pam_end(
	pam_handle_t *pamh,
	int status
){
	return PAM_SUCCESS;
}
