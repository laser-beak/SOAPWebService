CREATE TABLE public.responseResult
(
    id bigint NOT NULL DEFAULT nextval('result_id_seq'::regclass),
    code character varying(50) COLLATE pg_catalog."default",
    error character varying(100) COLLATE pg_catalog."default",
    filenames character varying(100) COLLATE pg_catalog."default",
    "number" integer,
    CONSTRAINT result_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.responseResult
    OWNER to postgres;