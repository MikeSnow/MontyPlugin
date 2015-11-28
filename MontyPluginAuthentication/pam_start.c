#include <security/pam_appl.h>

extern int pam_start(
	const char *service,
	const char *user,
	const struct pam_conv *pam_conv,
	pam_handle_t **pamh
);

