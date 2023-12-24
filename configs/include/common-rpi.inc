include ${OB_DEFCONFIG_DIR}/include/common.inc

OB_BB_LAYERS += ${OB_ROOT_DIR}/platform/meta-raspberrypi

OB_BB_EXPORT_VARIABLES += TEMPLATECONF
TEMPLATECONF = ${OB_ROOT_DIR}/platform/meta-birdycamcam/conf/templates/raspberrypi
