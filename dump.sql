--
-- PostgreSQL database dump
--

-- Dumped from database version 10.1
-- Dumped by pg_dump version 10.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE database_document_processing;
--
-- Name: database_document_processing; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE database_document_processing


ALTER DATABASE database_document_processing OWNER TO postgres;

\connect database_document_processing

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: administrators; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE administrators (
    id integer NOT NULL,
    login character varying(45) NOT NULL,
    password character varying(45) NOT NULL
);


ALTER TABLE administrators OWNER TO postgres;

--
-- Name: administrators_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE administrators_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE administrators_id_seq OWNER TO postgres;

--
-- Name: administrators_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE administrators_id_seq OWNED BY administrators.id;


--
-- Name: upload_permission; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE upload_permission (
    id integer NOT NULL,
    name character varying(45) NOT NULL,
    doc_type character varying(45) NOT NULL,
    device character varying(45) NOT NULL
);


ALTER TABLE upload_permission OWNER TO postgres;

--
-- Name: upload_permission_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE upload_permission_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE upload_permission_id_seq OWNER TO postgres;

--
-- Name: upload_permission_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE upload_permission_id_seq OWNED BY upload_permission.id;


--
-- Name: administrators id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY administrators ALTER COLUMN id SET DEFAULT nextval('administrators_id_seq'::regclass);


--
-- Name: upload_permission id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY upload_permission ALTER COLUMN id SET DEFAULT nextval('upload_permission_id_seq'::regclass);


--
-- Data for Name: administrators; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO administrators (id, login, password) VALUES (1, 'gabi', '827ccb0eea8a706c4c34a16891f84e7b');


--
-- Data for Name: upload_permission; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO upload_permission (id, name, doc_type, device) VALUES (1, 'gabriele', 'image', 'web');
INSERT INTO upload_permission (id, name, doc_type, device) VALUES (2, 'Maria', 'PDF', 'Mobile');


--
-- Name: administrators_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('administrators_id_seq', 1, true);


--
-- Name: upload_permission_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('upload_permission_id_seq', 3, true);


--
-- Name: administrators administrators_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY administrators
    ADD CONSTRAINT administrators_pkey PRIMARY KEY (id);


--
-- Name: upload_permission upload_permission_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY upload_permission
    ADD CONSTRAINT upload_permission_pkey PRIMARY KEY (id);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

